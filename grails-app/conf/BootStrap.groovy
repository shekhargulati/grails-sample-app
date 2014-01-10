import sampleapp.Story

class BootStrap {

    def init = { servletContext ->
        new Story(title: "Hello World 1", url: "http://google.com",submittedBy: "shekhargulati84@gmail.com").save(failOnError: true)
        new Story(title: "Hello World 2", url: "http://google.in",submittedBy: "shekhargulati84@gmail.com").save(failOnError: true)
        new Story(title: "Hello World 3", url: "http://google.pk",submittedBy: "shekhargulati84@gmail.com").save(failOnError: true)
    }
    def destroy = {
    }
}
