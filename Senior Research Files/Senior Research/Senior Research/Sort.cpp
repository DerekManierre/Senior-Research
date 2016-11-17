#include<iostream>
#include<fstream>
#include<string>
#include<ctime>
using namespace std;

void quickSort(int arr[], int low, int high);
int partition(int arr[], int low, int high);
void swap(int* a, int* b);

int main(){
		int i;
		double times[1000], total = 0, avg;
	for (int s = 0; s < 1000; s++){
		clock_t begin = clock();
		int list[5000], list1[5000], list2[5000];
		int count = 0, num = 0, temp, j, n = (sizeof(list)/sizeof(int));
		
		ifstream infile("nums.txt");
		string line;
		if (infile.is_open())
		{
			while (getline(infile, line))
			{
				num = stoi(line);
				list[count] = num;
				count++;
			}
		}
		for (int z = 0; z < 5000; z++){
			list1[z] = list[z];
			list2[z] = list[z];
		}


		// Insertion Sort
		for (int y = 0; y < 5000; y++){
			j = y;

			while (j > 0 && list[j] < list[j - 1]){
				temp = list[j];
				list[j] = list[j - 1];
				list[j - 1] = temp;
				j--;
			}
		}

		// Quick Sort    
		quickSort(list1, 0, n);

		// Bubble Sort
		for (int d = 1; d < n; ++d)
		{
			for (j = 0; j<(n - d); ++j)
			if (list2[j]>list2[j + 1])
			{
				temp = list2[j];
				list2[j] = list2[j + 1];
				list2[j + 1] = temp;
			}
		}

		clock_t end = clock();

		double time = double(end - begin) / CLOCKS_PER_SEC;
		times[s] = time;
	}
	for (int d = 0; d < 1000; d++){
		total = times[d] + total;
		avg = total / 1000;
	}
	ofstream myfile;
	myfile.open("time.txt");
	myfile << avg;
	myfile.close();
	return 0;
	}
void quickSort(int arr[], int low, int high){
	if (low < high)
	{
		int pi = partition(arr, low, high);

		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

int partition(int arr[], int low, int high){
	int pivot = arr[high];
	int i = (low - 1);

	for (int j = low; j <= high - 1; j++)
	{
		if (arr[j] <= pivot)
		{
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[high]);
	return (i + 1);
}
void swap(int* a, int* b){
	int t = *a;
	*a = *b;
	*b = t;
}