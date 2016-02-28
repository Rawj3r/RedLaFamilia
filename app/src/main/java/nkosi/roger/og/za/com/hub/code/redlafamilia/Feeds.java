package nkosi.roger.og.za.com.hub.code.redlafamilia;

/**
 * Created by empirestate on 2/8/16.
 */
public class Feeds {

    public String firstName, lastName, timeAdded, photo, comment;

    private Feeds(Builder builder){

        firstName = builder.firstName;
        lastName = builder.lastName;
        timeAdded = builder.timeAdded;
        photo = builder.photo;
        comment = builder.comment;
    }

    public static class Builder{
        public String firstName, lastName, timeAdded, photo, comment;

//        public String getComment() {
//            return comment;
//        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return Builder.this;
        }

//        public String getFirstName() {
//            return firstName;
//        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return Builder.this;
        }

//        public String getLastName() {
//            return lastName;
//        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return Builder.this;
        }

//        public String getPhoto() {
//            return photo;
//        }

        public Builder setPhoto(String photo) {
            this.photo = photo;
            return Builder.this;
        }

//        public String getTime() {
//            return timeAdded;
//        }

        public Builder setTime(String timeAdded) {
            this.timeAdded = timeAdded;
            return Builder.this;
        }

        public Feeds build(){
            return new Feeds(Builder.this);
        }
    }
}
