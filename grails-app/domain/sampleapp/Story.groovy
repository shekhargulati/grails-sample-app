package sampleapp

class Story {

    String title
    String url
    Date submittedOn = new Date()
    String submittedBy

    static constraints = {
        url url:true
        submittedBy email: true
    }
}
