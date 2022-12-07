package no.solheim.adventofcode2022

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import no.solheim.adventofcode2022.tasks.DayTask

@SpringBootApplication
class Adventofcode2022Application

fun main(args: Array<String>) {
    runApplication<Adventofcode2022Application>(*args)
}

@Component
class Startup(val tasks: List<DayTask>) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {

        val dayToRun = 2
        tasks.map { (it::class.simpleName ?: "").replace("Day", "").toInt() to it }
            .first { (day, task) -> day == dayToRun }
            .second.run()
    }
}
