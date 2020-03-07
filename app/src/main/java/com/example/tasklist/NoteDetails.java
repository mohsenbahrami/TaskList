package com.example.tasklist;

public class NoteDetails {

        String title;
        String description;
        String date;
        int shape;
        int status;
        Boolean checked;

    public NoteDetails(String title, String description, String date, int shape, int status) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.shape = shape;
        this.status = status;
    }

    public NoteDetails() {
    }

    public NoteDetails(String title, String description, String date, int shape, int status, Boolean checked) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.shape = shape;
        this.status = status;
        this.checked = checked;
    }
    public NoteDetails(String title, String description, String date, int shape, Boolean checked) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.shape = shape;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}




