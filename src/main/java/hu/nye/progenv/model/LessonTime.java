package hu.nye.progenv.model;

public class LessonTime {
    private final Integer hour;
    private final Integer minute;

    public LessonTime(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hour == null) ? 0 : hour.hashCode());
        result = prime * result + ((minute == null) ? 0 : minute.hashCode());
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
        LessonTime other = (LessonTime) obj;
        if (hour == null) {
            if (other.hour != null)
                return false;
        } else if (!hour.equals(other.hour))
            return false;
        if (minute == null) {
            if (other.minute != null)
                return false;
        } else if (!minute.equals(other.minute))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LessonTime [hour=" + hour + ", minute=" + minute + "]";
    }

    
}
