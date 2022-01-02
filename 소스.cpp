#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int static compare(const void* first, const void* second)
{
	if (*(int*)first > * (int*)second)
		return 1;
	else if (*(int*)first < *(int*)second)
		return -1;
	else
		return 0;
}
int main() {
	int i, j,total=0;
	scanf("%d", &j);
	int arr[1000];
	for (i = 0; i < j; i++) {
		scanf("%d", &arr[i]);
	}

	qsort(arr, j,sizeof(int),compare);
	for (i = 0; i < j; i++) {
		printf("%d\n", arr[i]);
	}
}
