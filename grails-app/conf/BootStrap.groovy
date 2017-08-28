import grails.util.Environment
import playlogixskillstest.Watch

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            def w1 = new Watch(brand:"Swatch", model: "Classic", price: 500, warranty: 1).save(failOnError: true)
            def w2 = new Watch(brand:"Swatch", model: "Sport", price: 1500, warranty: 3).save(failOnError: true)
            def w3 = new Watch(brand: "Rolex", model: "Gold", price: 10000, warranty: 3).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
