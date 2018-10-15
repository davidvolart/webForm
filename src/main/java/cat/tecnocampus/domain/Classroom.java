package cat.tecnocampus.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Classroom {


    @NotNull
    @Size(min = 3, message = "Name field must have at least 3 characters")
    private String name;

    @NotNull
    private int capacity;

    @NotNull
    @Size(min = 3, message = "Orientation field must have at least 3 characters")
    private String orientation;

    @NotNull
    private boolean plugs;


    public Classroom() {

    }

    public Classroom(ClassroomBuilder builder) {
        name = builder.name;
        capacity = builder.capacity;
        orientation = builder.orientation;
        plugs = builder.plugs;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getOrientation() {
        return orientation;
    }

    public boolean isPlugs() {
        return plugs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setPlugs(boolean plugs) {
        this.plugs = plugs;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", orientation='" + orientation + '\'' +
                ", plugs=" + plugs +
                '}';
    }

    public static class ClassroomBuilder {
        public String name;
        public int capacity;
        public String orientation;
        public boolean plugs;

        public ClassroomBuilder() {
        }

        public ClassroomBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClassroomBuilder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public ClassroomBuilder orientation(String orientation) {
            this.orientation = orientation;
            return this;
        }

        public ClassroomBuilder plugs(boolean plugs) {
            this.plugs = plugs;
            return this;
        }

        public Classroom build() {
            return new Classroom(this);
        }
    }
}
