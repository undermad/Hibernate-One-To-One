package org.example.one_to_one.entity;



import javax.persistence.*;

// make sure you use javax.persistence.* imports - NOT HIBERNATE!
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    // annotate the class as an entity and map to db table

    // define the fields

    //annotate the fields with db column names

    //create constructors

    //generate getters and setters

    //override toString method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return this.id
                + "\nYt: " + this.youtubeChannel +
                "\nHobby: " + this.hobby;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
