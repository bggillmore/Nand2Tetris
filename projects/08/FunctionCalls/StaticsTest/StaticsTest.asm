@261
D=A
@SP
M=D
@Sys.init
0;JMP

//writeFunction Class1.set 0
(Class1.set)

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

//pop static 0
@Class1.vm.0
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

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

//pop static 1
@Class1.vm.1
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

//writeReturn
@LCL
D=M
@FRAME
M=D
@FRAME
D=M
@5
A=D-A
D=M
@RET
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@SP
M=M-1
@ARG
D=M+1
@SP
M=D
@FRAME
A=M-1
D=M
@THAT
M=D
@FRAME
D=M
@2
A=D-A
D=M
@THIS
M=D
@FRAME
D=M
@3
A=D-A
D=M
@ARG
M=D
@FRAME
D=M
@4
A=D-A
D=M
@LCL
M=D
@RET
A=M
0;JMP

//writeFunction Class1.get 0
(Class1.get)

//push static 0
@Class1.vm.0
D=M
@SP
A=M
M=D
@SP
M=M+1

//push static 1
@Class1.vm.1
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

//writeReturn
@LCL
D=M
@FRAME
M=D
@FRAME
D=M
@5
A=D-A
D=M
@RET
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@SP
M=M-1
@ARG
D=M+1
@SP
M=D
@FRAME
A=M-1
D=M
@THAT
M=D
@FRAME
D=M
@2
A=D-A
D=M
@THIS
M=D
@FRAME
D=M
@3
A=D-A
D=M
@ARG
M=D
@FRAME
D=M
@4
A=D-A
D=M
@LCL
M=D
@RET
A=M
0;JMP

@256
D=A
@SP
M=D
@Sys.init
0;JMP

//writeFunction Class2.set 0
(Class2.set)

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

//pop static 0
@Class2.vm.0
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

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

//pop static 1
@Class2.vm.1
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

//writeReturn
@LCL
D=M
@FRAME
M=D
@FRAME
D=M
@5
A=D-A
D=M
@RET
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@SP
M=M-1
@ARG
D=M+1
@SP
M=D
@FRAME
A=M-1
D=M
@THAT
M=D
@FRAME
D=M
@2
A=D-A
D=M
@THIS
M=D
@FRAME
D=M
@3
A=D-A
D=M
@ARG
M=D
@FRAME
D=M
@4
A=D-A
D=M
@LCL
M=D
@RET
A=M
0;JMP

//writeFunction Class2.get 0
(Class2.get)

//push static 0
@Class2.vm.0
D=M
@SP
A=M
M=D
@SP
M=M+1

//push static 1
@Class2.vm.1
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

//writeReturn
@LCL
D=M
@FRAME
M=D
@FRAME
D=M
@5
A=D-A
D=M
@RET
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@SP
M=M-1
@ARG
D=M+1
@SP
M=D
@FRAME
A=M-1
D=M
@THAT
M=D
@FRAME
D=M
@2
A=D-A
D=M
@THIS
M=D
@FRAME
D=M
@3
A=D-A
D=M
@ARG
M=D
@FRAME
D=M
@4
A=D-A
D=M
@LCL
M=D
@RET
A=M
0;JMP

@256
D=A
@SP
M=D
@Sys.init
0;JMP

//writeFunction Sys.init 0
(Sys.init)

//push constant 6
@6
D=A
@SP
A=M
M=D
@SP
M=M+1

//push constant 8
@8
D=A
@SP
A=M
M=D
@SP
M=M+1

//writeCall Class1.set 2
@Class1.set_0_return
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class1.set
0;JMP
(Class1.set_0_return)

//pop temp 0
@R5
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//push constant 23
@23
D=A
@SP
A=M
M=D
@SP
M=M+1

//push constant 15
@15
D=A
@SP
A=M
M=D
@SP
M=M+1

//writeCall Class2.set 2
@Class2.set_1_return
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class2.set
0;JMP
(Class2.set_1_return)

//pop temp 0
@R5
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D

//writeCall Class1.get 0
@Class1.get_2_return
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class1.get
0;JMP
(Class1.get_2_return)

//writeCall Class2.get 0
@Class2.get_3_return
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class2.get
0;JMP
(Class2.get_3_return)

//Label null.WHILE
(null.WHILE)

//GoTo null.WHILE
@null.WHILE
0;JMP

