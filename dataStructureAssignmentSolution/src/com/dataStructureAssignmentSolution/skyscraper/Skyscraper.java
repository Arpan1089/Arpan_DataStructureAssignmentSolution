package com.dataStructureAssignmentSolution.skyscraper;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Skyscraper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int size = sc.nextInt();
		LinkedList<Integer> ip = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int value = sc.nextInt();
			ip.add(value);
		}
		System.out.println("The order of construction is as follows");
		List<Integer> sortedlist = ip.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		Queue<Integer> op = new LinkedList<>();
		int day = -1;
		int imax =-1;
		int initial = 0;
		day =0;
		op.clear();
		Integer remainingListmax = -1;
		for(int i=0;i<sortedlist.size();i++) {
		imax =ip.indexOf(sortedlist.get(i));
		List<Integer> currentSublist = ip.subList(initial, imax+1);
		if(imax+2< sortedlist.size())
		remainingListmax = Collections.max(ip.subList(imax+2, ip.size()));
		else
		remainingListmax = -1;
		for(int k=i;k<sortedlist.size();k++) {
		if(remainingListmax !=-1) {
		if(currentSublist.contains(sortedlist.get(k)) && sortedlist.get(k)>remainingListmax) {
		op.add(sortedlist.get(k));
		i++;
		}
		}
		else {
		op.add(sortedlist.get(k));
		i++;
		}

		}
		i=i-1;
		for(int j=initial;j<imax;j++) {
		day = j+1;
		System.out.println("Day "+day+": ");
		}
		day=imax+1;
		System.out.println("Day "+day+": "+op);
		op.clear();
		initial = day;
		}
//		Queue<Integer> matchedOutput = new LinkedList<>();
//		int day = -1;
//		int matchpoint = -1;
//		for (int i = 0; i < inputList.size(); i++) {
//			day = i + 1;
//			if (matchpoint == -1) {
//				matchpoint = sortedlist.get(i);
//			}
//			if (inputList.get(i) == matchpoint) {
//				if (matchedOutput.isEmpty()) {
//					System.out.println("Day: " + day);
//					System.out.println(matchpoint);
//				} else {
//					matchedOutput.add(sortedlist.get(i));
//					System.out.println("Day : " + day);
//					for (Integer item : matchedOutput) {
//						System.out.print(item + " ");
//					}
//					System.out.println();
//					matchedOutput.clear();
//				}
//				matchpoint = -1;
//			} else {
//				System.out.println("Day : " + day);
//				System.out.println();
//				matchedOutput.add(sortedlist.get(i));
//			}
//		}

		sc.close();
	}

}
