import org.springframework.core.io.Resource

fun Resource.nonBlankLines(): List<String> =
    String(this.inputStream.readAllBytes()).split("\n").filter { it.isNotBlank() }
