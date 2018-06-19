package com.bridgelabz.AlgorithmPrograms;

public class MergeSortFinal {
	public static void mergeSort(int []ar,int low,int high) {
		if(low<high) {
    		int mid=(high+low)/2;
    		mergeSort(ar,low,mid);
    		mergeSort(ar,mid+1, high);
    		merge(ar,low,high);
    	}
	}
	
	public static void merge(int[] ar, int low,int high) {
		int start=low;
		int mid=(high+low)/2;
		int l=low;
		int k=mid+1;
		int []b=new int[100];
		while(low<=mid&&k<=high) {
			if(ar[low]>=ar[k]) {
				b[l]=ar[k];
				k++;
			}
			else {
				b[l]=ar[low];
				low++;
			}
			l++;
		}
		if(low>mid) {
			while(k<=high) {
				b[l]=ar[k];
				l++;
				k++;
			}
		}
		else {
			while(low<=mid) {
				b[l]=ar[low];
				l++;
				low++;
			}
		}
		for (int i = 0; i < b.length; i++) {
			ar[i]=b[i];
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
	}

	public static void main(String[] args) {
		int[] a= {7,3,4,5,1,3,9};
		mergeSort(a, 0, a.length-1);
	}

}


