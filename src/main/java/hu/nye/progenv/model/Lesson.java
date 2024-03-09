package hu.nye.progenv.model;

public class Lesson {
    private final Integer id;
    private final String name;
    private final String day;
    private final LessonTime startTime;
    private final LessonTime stopTime;
    private final String room;

    public Lesson(Integer id, String name, String day, LessonTime startTime, LessonTime stopTime, String room) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public LessonTime getStartTime() {
        return startTime;
    }

    public LessonTime getStopTime() {
        return stopTime;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((stopTime == null) ? 0 : stopTime.hashCode());
        result = prime * result + ((room == null) ? 0 : room.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lesson other = (Lesson) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (stopTime == null) {
            if (other.stopTime != null)
                return false;
        } else if (!stopTime.equals(other.stopTime))
            return false;
        if (room == null) {
            if (other.room != null)
                return false;
        } else if (!room.equals(other.room))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Lesson [id=" + id + ", name=" + name + ", day=" + day + ", startTime=" + startTime + ", stopTime="
                + stopTime + ", room=" + room + "]";
    };

    


}
