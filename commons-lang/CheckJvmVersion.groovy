@Grab('org.apache.commons:commons-lang3:3.8.1')
import static org.apache.commons.lang3.SystemUtils.isJavaVersionAtLeast as atLeast
import static org.apache.commons.lang3.JavaVersion.JAVA_1_8 as Java8
import java.util.stream.IntStream

println atLeast(Java8) ?
        IntStream.range(1, 5).reduce{ a, b -> a + b }.asInt :
        (1..<5).sum()

import org.apache.commons.lang3.time.DurationFormatUtils as DFU

println DFU.formatDurationWords(((23 * 60 + 59) * 60 + 59) * 1000L, true, true)
