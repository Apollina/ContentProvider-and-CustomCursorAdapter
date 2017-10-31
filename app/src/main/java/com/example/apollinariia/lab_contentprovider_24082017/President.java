package com.example.apollinariia.lab_contentprovider_24082017;

/**
 * Created by Apollinariia on 8/29/2017.
 */

public class President {
    public String surname;
    public String name;
    public String startDate;
    public String endDate;

    public President(String surname, String name, String startDate, String endDate ) {
        this.surname=surname;
        this.name=name;
        this.startDate=startDate;
        this.endDate=endDate;

    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
