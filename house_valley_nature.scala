//#######################################################
// Brain Boost 
//#######################################################

//Imports
import scala.collection.mutable.ListBuffer

// Define custom classes
abstract class CustomMathFunction {
    def apply(x: Int): Int
}
case class CustomAddition(var addStep: Int = 0) extends CustomMathFunction {
    override def apply(x: Int): Int = x + addStep
}
case class CustomSubtraction(var subtractStep: Int = 0) extends CustomMathFunction {
    override def apply(x: Int): Int = x - subtractStep
}
case class CustomMultiplication(var multiplyStep: Int = 0) extends CustomMathFunction {
    override def apply(x: Int): Int = x * multiplyStep
}
case class CustomDivision(var divideStep: Int = 0) extends CustomMathFunction {
    override def apply(x: Int): Int = x / divideStep
}

// Function to calculate an array of custom functions
def processArrayCustomFunctions(inputArray: Array[Int], 
                                customFunctions: Array[CustomMathFunction]): Array[Int] = {
    var outputArray = inputArray
    for (customFunction <- customFunctions) {
        for (i <- 0 until outputArray.length) {
            outputArray(i) = customFunction.apply(outputArray(i))
        }
    }
    outputArray
}

// Function to find the top N values in an array
def findTopValues(inputArray: Array[Int], topN: Int): List[Int] = {
    val listBuffer = ListBuffer.empty[Int]
    inputArray.foreach(listBuffer += _)
    listBuffer.sortWith(_ > _).take(topN).toList
}

// Function to calculate the average of an array
def calculateAverage(inputArray: Array[Int]): Double = {
    var sum = 0
    for (value <- inputArray) {
        sum += value
    }
    (sum / inputArray.length).toDouble
}

// Function to find the minimum value in an array
def findMinValue(inputArray: Array[Int]): Int = {
    inputArray.min
}

// Function to find the maximum value in an array
def findMaxValue(inputArray: Array[Int]): Int = {
    inputArray.max
}

// Function to calculate the sum of an array
def calculateSum(inputArray: Array[Int]): Int = {
    inputArray.sum
}

// Main function
def brainBoost(inputArray: Array[Int], customFunctions: Array[CustomMathFunction]): Unit = {
    // Calculate the output array
    val outputArray = processArrayCustomFunctions(inputArray, customFunctions)
    
    // Calculate the top 3 values
    val top3Values = findTopValues(outputArray, 3)
    println("Top 3 values: " + top3Values.mkString(", "))
    
    // Calculate the average
    val avgValue = calculateAverage(outputArray)
    println("Average Value: " + avgValue)
    
    // Calculate the minimum value
    val minValue = findMinValue(outputArray)
    println("Min Value: " + minValue)
    
    // Calculate the maximum value
    val maxValue = findMaxValue(outputArray)
    println("Max Value: " + maxValue)
    
    // Calculate the sum
    val sum = calculateSum(outputArray)
    println("Sum: " + sum)
}

// Run 
val inputArray = Array(1, 5, 8, 9, 10, 14)
val customFunctions = Array[CustomMathFunction](CustomAddition(4), 
                                                CustomMultiplication(2), 
                                                CustomSubtraction(3))
brainBoost(inputArray, customFunctions)