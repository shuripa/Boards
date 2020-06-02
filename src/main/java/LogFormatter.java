import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return String.valueOf(new StringBuilder()
                .append("[" + record.getLevel().toString() + "]")
                .append(new Date(record.getMillis()))
                .append(" " + record.getSourceClassName() +"{} ")
                .append(record.getSourceMethodName() + "() ")
                .append(record.getMessage())
                .append("\n"));
    }
}
