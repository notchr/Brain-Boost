# Brain Boost

#create a class
class BrainBoost
  #initialize the class
  def initialize
    @count = 0
  end
  #create a method to increase the count by one
  def increment
    @count += 1
  end
  #print the number
  def result
    puts @count
  end
end

# create an object
number = BrainBoost.new

# loop through 2000 times and increment the count
2000.times do
  number.increment
end

#print the count
number.result