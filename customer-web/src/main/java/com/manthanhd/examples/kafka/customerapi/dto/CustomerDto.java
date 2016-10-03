package com.manthanhd.examples.kafka.customerapi.dto;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class CustomerDto {

    private String id, first_name, last_name, email_address;

    private CustomerDto(Builder builder) {
        setId(builder.id);
        setFirst_name(builder.first_name);
        setLast_name(builder.last_name);
        setEmail_address(builder.email_address);
    }

    public CustomerDto() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public static final class Builder {
        private String id;
        private String first_name;
        private String last_name;
        private String email_address;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder first_name(String val) {
            first_name = val;
            return this;
        }

        public Builder last_name(String val) {
            last_name = val;
            return this;
        }

        public Builder email_address(String val) {
            email_address = val;
            return this;
        }

        public CustomerDto build() {
            return new CustomerDto(this);
        }
    }
}
