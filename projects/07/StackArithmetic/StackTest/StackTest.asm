//C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@NEQ_JUMP_0
D;JNE
D=-1
@EQ_JUMP_0
D;JNE
(NEQ_JUMP_0)
D=0
(EQ_JUMP_0)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 16
@16
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@NEQ_JUMP_1
D;JNE
D=-1
@EQ_JUMP_1
D;JNE
(NEQ_JUMP_1)
D=0
(EQ_JUMP_1)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 16
@16
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@NEQ_JUMP_2
D;JNE
D=-1
@EQ_JUMP_2
D;JNE
(NEQ_JUMP_2)
D=0
(EQ_JUMP_2)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 892
@892
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@LT_JUMP_0
D;JLT
D=0
@NLT_JUMP_0
0;JMP
(LT_JUMP_0)
D=-1
(NLT_JUMP_0)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 892
@892
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@LT_JUMP_1
D;JLT
D=0
@NLT_JUMP_1
0;JMP
(LT_JUMP_1)
D=-1
(NLT_JUMP_1)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@LT_JUMP_2
D;JLT
D=0
@NLT_JUMP_2
0;JMP
(LT_JUMP_2)
D=-1
(NLT_JUMP_2)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 32767
@32767
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@GT_JUMP_0
D;JGT
D=0
@NGT_JUMP_0
0;JMP
(GT_JUMP_0)
D=-1
(NGT_JUMP_0)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 32767
@32767
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@GT_JUMP_1
D;JGT
D=0
@NGT_JUMP_1
0;JMP
(GT_JUMP_1)
D=-1
(NGT_JUMP_1)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//eq
@SP
A=M-1
D=-M
A=A-1
D=D+M
@SP
M=M-1
M=M-1
@GT_JUMP_2
D;JGT
D=0
@NGT_JUMP_2
0;JMP
(GT_JUMP_2)
D=-1
(NGT_JUMP_2)
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH constant 57
@57
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 31
@31
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 53
@53
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

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

//C_PUSH constant 112
@112
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

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

//neg
@SP
A=M-1
D=-M
M=D
D=A+1
@SP
M=D

//and
@SP
A=M-1
D=M
A=A-1
D=D&M
M=D
D=A+1
@SP
M=D

//C_PUSH constant 82
@82
D=A
@SP
A=M
M=D
D=A+1
@SP
M=D

//and
@SP
A=M-1
D=M
A=A-1
D=D|M
M=D
D=A+1
@SP
M=D

//not
@SP
A=M-1
D=!M
M=D
D=A+1
@SP
M=D

