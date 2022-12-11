package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.core.io.ByteArrayResource

class Task2Test {

    @Test
    fun a() {
        val example = """A Y
B X
C Z"""
        Day2(ByteArrayResource(example.toByteArray())).run()
    }
}
