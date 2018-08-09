//push argument 1
@1
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//pop pointer 1
@R4
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push constant 0
@0
D=A
@SP
A=M
M=D
@SP
M=M+1

//pop that 0
@THAT
D=M
@0
D=A+D
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push constant 1
@1
D=A
@SP
A=M
M=D
@SP
M=M+1

//pop that 1
@THAT
D=M
@1
D=A+D
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push argument 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//push constant 2
@2
D=A
@SP
A=M
M=D
@SP
M=M+1

//sub
@SP
A=M-1
D=M
A=A-1
D=M-D
M=D
D=A+1
@SP
M=D

//pop argument 0
@ARG
D=M
@0
D=A+D
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//Label null.MAIN_LOOP_START
(null.MAIN_LOOP_START)

//push argument 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//If_GoTo null.COMPUTE_ELEMENT
@SP
AM=M-1
D=M
@null.COMPUTE_ELEMENT
D;JGT

//GoTo null.END_PROGRAM
@null.END_PROGRAM
0;JMP

//Label null.COMPUTE_ELEMENT
(null.COMPUTE_ELEMENT)

//push that 0
@0
D=A
@THAT
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//push that 1
@1
D=A
@THAT
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//add
@SP
A=M-1
D=M
A=A-1
D=D+M
M=D
D=A+1
@SP
M=D

//pop that 2
@THAT
D=M
@2
D=A+D
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push pointer 1
@R4
D=M
@SP
A=M
M=D
@SP
M=M+1

//push constant 1
@1
D=A
@SP
A=M
M=D
@SP
M=M+1

//add
@SP
A=M-1
D=M
A=A-1
D=D+M
M=D
D=A+1
@SP
M=D

//pop pointer 1
@R4
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push argument 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

//push constant 1
@1
D=A
@SP
A=M
M=D
@SP
M=M+1

//sub
@SP
A=M-1
D=M
A=A-1
D=M-D
M=D
D=A+1
@SP
M=D

//pop argument 0
@ARG
D=M
@0
D=A+D
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//GoTo null.MAIN_LOOP_START
@null.MAIN_LOOP_START
0;JMP

//Label null.END_PROGRAM
(null.END_PROGRAM)

