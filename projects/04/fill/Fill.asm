// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

(START)
@16384	//re/set counter for start of memory map
D=A
@counter
M=D

@24576	//get keyboard output
D=M

@BLACK		//jump to black if keyboard != 0
D;JNE

@WHITE		//jump to white if keyboard == 0
D;JEQ

(WHITE)
@24576	//if key is pressed during whitening loop, break and go back to start
D=M
@START
D;JNE

@counter	//start setting pixels to white to white
D=M
A=M
M=0

D=D+1		//increment pixel space
@counter
M=D

@24576
D=D-A	//if memory address is outside of screen memory map restart addresses
@SKIPWHITE
D;JLE
@16384
D=A
@counter
M=D
(SKIPWHITE)

@WHITE		//jump back to begininng of loop and do next pixel space
0;JMP


(BLACK)
@24576	//if key is pressed during blackening loop, break and go back to start
D=M
@START
D;JEQ

@counter	//start setting pixels to black
D=M
A=M
M=-1

D=D+1		//increment pixel space
@counter
M=D

@24576
D=D-A	//if memory address is outside of screen memory map restart addresses
@SKIPBLACK
D;JLE
@16384
D=A
@counter
M=D
(SKIPBLACK)

@BLACK		//jump back to begininng of loop and do next pixel space
0;JMP
