fun String.nonBlankLines(): List<String> = this.split("\n").filter { it.isNotBlank() }
