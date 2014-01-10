import sampleapp.Story

class BootStrap {

    def init = { servletContext ->
        new Story(title: "Hello World 1", url: "http://google.com").save()
        new Story(title: "Hello World 2", url: "http://google.in").save()
        new Story(title: "Hello World 3", url: "http://google.pk").save()
    }
    def destroy = {
    }
}
