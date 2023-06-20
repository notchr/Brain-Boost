Public Class BrainBoost
    Dim rand As New Random

    Sub Main()
        Dim start As Integer = 0
        Dim end As Integer = 10
        Dim diff As Integer = 0
        Dim randomNumber As Integer

        diff = (end - start) + 1

        randomNumber = rand.Next(start, end)

        BrainBoostGame(randomNumber, start, end)
     End Sub

    Sub BrainBoostGame(randomNumber As Integer, start As Integer, end As Integer)
        Dim guess As Integer
        Do
            Console.Write("Guess a number between {0} and {1}:  ", start, end)
            guess = Console.ReadLine()

            If guess = randomNumber Then
                Console.WriteLine("You guessed the correct number!")
            ElseIf guess > randomNumber Then
                Console.WriteLine("Your guess is too high!")
            Else
                Console.WriteLine("Your guess is too low!")
            End If
        Loop Until guess = randomNumber
    End Sub

End Class