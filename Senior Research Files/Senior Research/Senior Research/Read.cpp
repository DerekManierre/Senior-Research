#include<iostream>
#include<fstream>
#include<string>
#include<vector>

using namespace std;

int main(){
	std::vector<string> lines;
	std::vector<string> words;
	char* point;

	ifstream infile("test.txt");
	std::string sentence;
	if (infile.is_open()){
		while (getline(infile, sentence))
		{
			lines.push_back(sentence);
		}
	}

	for (int i = 0; i < lines.size; i++){
		point = strtok(lines.pop_back, " ");
		while (point != NULL){
			words.push_back(point);
		}
		for (int x = 0; x < words.size; x++){
			cout << words.back;
			words.pop_back;
		}
}