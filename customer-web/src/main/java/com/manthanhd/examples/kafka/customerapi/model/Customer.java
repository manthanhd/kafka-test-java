package com.manthanhd.examples.kafka.customerapi.model;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class Customer {

    private String id, firstName, lastName, emailAddress;

    private Customer(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        emailAddress = builder.emailAddress;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private String emailAddress;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder emailAddress(String val) {
            emailAddress = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
