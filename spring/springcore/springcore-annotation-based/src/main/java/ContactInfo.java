public final class ContactInfo {
    private String email;
    private String mobileNo;

    public ContactInfo(String email, String mobileNo) {
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
