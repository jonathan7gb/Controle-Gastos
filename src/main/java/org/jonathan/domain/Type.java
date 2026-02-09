package org.jonathan.domain;

public enum Type {

    INCOME("Income"),
    EXPENSE("Expense");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
