package com.example.geekbrainslessons;

public class Calculation {

    private String member = "";
    private String lefVal = "";
    private char lastOperationKey;
    private int result = 0;

    public String getMember() {
        return lefVal + lastOperationKey + member;
    }

    public void setMember(String member) {
        this.member += member;
    }

    public String getLefVal() {
        return lefVal;
    }

    public void setLefVal() {
        this.lefVal = this.member;
        this.member = "";
    }

    public char getLastOperationKey() {
        return lastOperationKey;
    }

    public void setLastOperationKey(char lastOperationKey) {

        if (lastOperationKey == 'c') {
            this.lastOperationKey = Character.MIN_VALUE;
            lefVal = "";
            member = "";
        } else if (lastOperationKey == '=') {
            lefVal = Integer.toString(result);
            member = "";
            this.lastOperationKey = Character.MIN_VALUE;
        } else {
            this.lastOperationKey = lastOperationKey;
        }
    }

    String getResult() {

        int currentVal = Integer.parseInt(member);
        int memVal = Integer.parseInt(lefVal);

        if (lastOperationKey == '/') {

            if (currentVal == 0) {
                return "Нельзя делить на ноль!";
            } else {
                result = memVal / currentVal;
            }

        } else if (lastOperationKey == '*') {
            result = memVal * currentVal;
        } else if (lastOperationKey == '-') {
            result = memVal - currentVal;
        } else if (lastOperationKey == '+') {
            result = memVal + currentVal;
        }

        lastOperationKey = '=';

        return Integer.toString(result);
    }

}
