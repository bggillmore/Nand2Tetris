//push constant 111
@111
D=A
@SP
A=M
M=D
@SP
M=M+1

//push constant 333
@333
D=A
@SP
A=M
M=D
@SP
M=M+1

//push constant 888
@888
D=A
@SP
A=M
M=D
@SP
M=M+1

//pop static 8
@StaticTest.asm.8
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//pop static 3
@StaticTest.asm.3
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//pop static 1
@StaticTest.asm.1
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push static 3
@StaticTest.asm.3
D=M
@SP
A=M
M=D
@SP
M=M+1

//push static 1
@StaticTest.asm.1
D=M
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

//push static 8
@StaticTest.asm.8
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

