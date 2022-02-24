import java.awt.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*

var name = "" //variables that will be used to create your character
var type = ""
var color = ""
var home = ""

/**
 * Program that creates a character based on user inputs
 */
fun main() {
    print("Hello World! What is my name? ") //print the first prompt
    name = readLine().toString() //get input from user, cast it as a string and set it as the name
    println("$name... has a nice ring to it. But what am I?") //second question
    var validInput = false //set variable for the loop
    while(!validInput) { //loop until we get valid input
        print("A Tiger? A Robot? Or a Baby? ") //ask this until we get valid input
        type = readLine().toString().lowercase() //get lowercase string input and set it as the type.
        if (type == "tiger") { //check if they typed tiger
            println("So I'm a tiger! Cool!")
            validInput = true //we have a valid input
        } else if (type == "robot") { //check if they typed robot
            println("I'm a robot?! Beep Boop!")
            validInput = true //we have a valid input
        } else if (type == "baby") { //check if they typed baby
            println("I'm a baby! LOL!")
            validInput = true //we have a valid input
        } else { //the user input is invalid
            println("$type is not a tiger, robot, or baby!") //scold the user
        }
    }
    println("But what color $type am I?") //third question
    print("Red, yellow or blue? ")
    validInput = false //set bool as false again, so we can reuse it for the next loop
    while(!validInput) { //same configuration as above, check if they inputted something valid.
        color = readLine().toString().lowercase()
        if (color == "red") {
            println("Oh, so I'm a red $type? Epic!")
            validInput = true
        } else if (color == "yellow") {
            println(("I'm a yellow $type! Neat!"))
            validInput = true
        } else if (color == "blue") {
            println("A blue $type? Who ever heard of such a thing?")
            validInput = true
        } else { //invalid input
            print("Please choose red, yellow or blue! ")
        }
    }
    println("Lastly, where do I live?") //final question
    print("In the Jungle? The ocean? Or on the moon? ")
    validInput = false //set bool as false yet again
    while(!validInput) { //same configuration as above, check if they inputted something valid.
        home = readLine().toString().lowercase()
        if (home == "jungle") {
            validInput = true
        } else if (home == "ocean") {
            validInput = true
        } else if (home == "moon") {
            validInput = true
        } else { //invalid input
            print("Please type either jungle, ocean, or moon! ")
        }
    }
    print("Hello World! I'm $name, a $color $type whose home is the $home.") //print all the answers
    EventQueue.invokeLater(::window) //open a window displaying the character
}

/**
 * Creates the window.
 */
fun window() {
    var wn = JFrame(name) //create JFrame with the name of the previously chosen name
    wn.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    wn.setSize(600, 600)
    wn.isVisible = true
    //get image paths using the home, type, and color
    val bgimg: BufferedImage = ImageIO.read(File("sprites/$home.png"))
    val picLabel: BufferedImage = ImageIO.read(File("sprites/$type" + "_" + "$color.png"))
    wn.contentPane = RenderImages(bgimg, picLabel); //render both images
}

/**
 * class solely used for drawing images on the JFrame. Extends JComponent
 */
internal class RenderImages(private val image: Image, private val image2: Image) : JComponent() {
    /**
     * Draws 2 images by overriding the paint component
     */
    @Override
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawImage(image, 0, 0, this) //draws image at 0,0
        g.drawImage(image2, 80, 100, this) // draws image at 80,100
    }
}
