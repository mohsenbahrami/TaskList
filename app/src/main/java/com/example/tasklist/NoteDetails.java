package com.example.tasklist;

public class NoteDetails {

        String title;
        String description;
        int shape;
        int status;

        public NoteDetails(String title, String descrioption, int shape, int status ){
            this.title = title;
            this.description = descrioption;
            this.shape = shape;
            this.status = status;
        }

        public NoteDetails(String title, String descrioption, int status ){
            this.title = title;
            this.description = descrioption;
            this.shape = 0;
            this.status = status;
        }


        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getShape() {
            return shape;
        }

        public int getStatus() {
            return status;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setShape(int shape) {
            this.shape = shape;
        }

        public void setStatus(int status) {
            this.status = status;
        }


}
