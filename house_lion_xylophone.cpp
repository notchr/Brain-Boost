#include <iostream>
#include <string>

// Function prototypes
void incrementNumber(int* numPtr);
int doubleNumber(int num);
int calculateSquare(int num);
int calculateCube(int num);
bool checkForPrime(int num);

int main(int argc, char* argv[])
{
	// Declare a variable to store a number
	int number = 0;

	// Welcome the user and explain the program
	std::cout << "Welcome to Brain Boost!\nThis program will increment a number and calculate its square, cube, and prime factors.\n";

	// Request user input via the console
	std::cout << "Please enter a number: ";
	std::cin >> number;

	// Output the current number
	std::cout << "Current number: " << number << "\n\n";

	// Increment the number
	incrementNumber(&number);

	// Output the incremented number
	std::cout << "Incremented number: " << number << "\n\n";

	// Double the number
	int doubledNumber = doubleNumber(number);

	// Output the doubled number
	std::cout << "Doubled number: " << doubledNumber << "\n\n";

	// Calculate the number's square
	int squareNumber = calculateSquare(doubledNumber);

	// Output the number's square
	std::cout << "Square of the number: " << squareNumber << "\n\n";

	// Calculate the number's cube
	int cubeNumber = calculateCube(doubledNumber);

	// Output the number's cube
	std::cout << "Cube of the number: " << cubeNumber << "\n\n";

	// Check if the number is prime
	bool isPrime = checkForPrime(doubledNumber);

	// Output the result of the prime check
	if (isPrime)
	{
		std::cout << "The number is prime.\n\n";
	}
	else
	{
		std::cout << "The number is not prime.\n\n";
	}

	// Thank the user for using the program
	std::cout << "Thank you for using Brain Boost!\n";

	return 0;
}

// Function definitions

void incrementNumber(int* numPtr)
{
	// Increment the number
	(*numPtr)++;
}

int doubleNumber(int num)
{
	// Double the number
	return num * 2;
}

int calculateSquare(int num)
{
	// Calculate the number's square
	return num * num;
}

int calculateCube(int num)
{
	// Calculate the number's cube
	return num * num * num;
}

bool checkForPrime(int num)
{
	// Check if the number is prime
	bool isPrime = true;
	for (int i = 2; i < num; i++)
	{
		if (num % i == 0)
		{
			isPrime = false;
			break;
		}
	}
	return isPrime;
}