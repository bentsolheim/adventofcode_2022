package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6Test : AdventTest() {

    @Test
    fun example() {
        assertThat(Day6("mjqjpqmgbljsphdztnvjfqwrcgsmlb").startOfPacketMarker).isEqualTo(7)
        assertThat(Day6("mjqjpqmgbljsphdztnvjfqwrcgsmlb").startOfMessageMarker).isEqualTo(19)
        assertThat(Day6("bvwbjplbgvbhsrlpgdmjqwftvncz").startOfPacketMarker).isEqualTo(5)
        assertThat(Day6("bvwbjplbgvbhsrlpgdmjqwftvncz").startOfMessageMarker).isEqualTo(23)
        assertThat(Day6("nppdvjthqldpwncqszvftbrmjlhg").startOfPacketMarker).isEqualTo(6)
        assertThat(Day6("nppdvjthqldpwncqszvftbrmjlhg").startOfMessageMarker).isEqualTo(23)
        assertThat(Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").startOfPacketMarker).isEqualTo(10)
        assertThat(Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").startOfMessageMarker).isEqualTo(29)
        assertThat(Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").startOfPacketMarker).isEqualTo(11)
        assertThat(Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").startOfMessageMarker).isEqualTo(26)
    }

    @Test
    fun input() {
        Day6(input).apply {
            println(startOfPacketMarker)
            println(startOfMessageMarker)
        }
    }
}
