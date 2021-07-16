package model;

import javafx.beans.property.SimpleStringProperty;


public class AdminTableModel {

    private SimpleStringProperty user_Name = new SimpleStringProperty("");
    private SimpleStringProperty user_Password = new SimpleStringProperty("");
    private SimpleStringProperty user_Email = new SimpleStringProperty("");
    private SimpleStringProperty user_Type = new SimpleStringProperty("");

    public AdminTableModel() {
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Email = user_Email;
        this.user_Type = user_Type;
    }

    public String getUser_Name() {
        return user_Name.get();
    }

    public SimpleStringProperty user_NameProperty() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name.set(user_Name);
    }

    public String getUser_Password() {
        return user_Password.get();
    }

    public SimpleStringProperty user_PasswordProperty() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password.set(user_Password);
    }

    public String getUser_Email() {
        return user_Email.get();
    }

    public SimpleStringProperty user_EmailProperty() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email.set(user_Email);
    }

    public String getUser_Type() {
        return user_Type.get();
    }

    public SimpleStringProperty user_TypeProperty() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type.set(user_Type);
    }
}
