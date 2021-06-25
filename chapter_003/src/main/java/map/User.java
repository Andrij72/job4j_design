package map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(name).append('|');
        sb.append(children).append('|');
        sb.append(birthday.get(Calendar.YEAR)).append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (getChildren() != user.getChildren()) {
            return false;
        }
        if (!getName().equals(user.getName())) {
            return false;
        }
        return getBirthday().equals(user.getBirthday());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getChildren();
        result = 31 * result + getBirthday().hashCode();
        return result;
    }
}
