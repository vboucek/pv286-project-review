package cz.muni.fi.pv286.arguments;

import cz.muni.fi.pv286.arguments.values.Format;
import cz.muni.fi.pv286.arguments.values.Option;
import org.junit.jupiter.api.Test;

class ProgramArgumentsTest {

    /* Printing help */
    @Test
    void printHelp_short() {
        String[] args = {"-h"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getHelp());
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void printHelp_long() {
        String[] args = {"--help"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getHelp());
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void printHelp_longWrong() {
        String[] args = {"-help"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void printHelp_moreArg() {
        String[] args = {"-h", "arg"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    /* Bytes format */
    @Test
    void formatBytes_short() {
        String[] args = {"-f", "bytes","-t", "bytes"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BYTES));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.BYTES));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void formatBytes_long() {
        String[] args = {"--from=bytes", "--to=bytes"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BYTES));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.BYTES));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void formatBytes_longShort() {
        String[] args = {"--from=bytes", "-t", "bytes"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BYTES));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.BYTES));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    /* Bytes format with options */

    @Test
    void optionBytes_big() {
        String[] args = {"--from=bytes", "-t", "bytes", "--from-options=big"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionBytes_little() {
        String[] args = {"--from=bytes", "-t", "bytes", "--to-options=little"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionBytes_delimiterShort() {
        String[] args = {"--from=bytes", "-t", "bytes", "-d", " "};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BYTES));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.BYTES));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(" "));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionBytes_delimiterLong() {
        String[] args = {"--from=bytes", "-t", "bytes", "-d", " . "};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BYTES));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.BYTES));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(" . "));
        } catch (Exception e) {
            assert(false);
        }
    }

    /* Bits format */
    @Test
    void formatBits_short() {
        String[] args = {"-f", "bits","-t", "bits"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BITS));
            assert(arguments.getInputOption().equals(Option.LEFT_PAD));
            assert(arguments.getOutputFormat().equals(Format.BITS));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(""));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void formatBits_long() {
        String[] args = {"--from=bits", "--to=bits"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BITS));
            assert(arguments.getInputOption().equals(Option.LEFT_PAD));
            assert(arguments.getOutputFormat().equals(Format.BITS));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(""));
        } catch (Exception e) {
            assert(false);
        }
    }

    /* Bits options */
    @Test
    void optionBits_delimiter() {
        String[] args = {"-f", "bits","-t", "bits", "-d", " "};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BITS));
            assert(arguments.getInputOption().equals(Option.LEFT_PAD));
            assert(arguments.getOutputFormat().equals(Format.BITS));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(" "));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionBits_left() {
        String[] args = {"-f", "bits","-t", "bits", "--from-options=left"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BITS));
            assert(arguments.getInputOption().equals(Option.LEFT_PAD));
            assert(arguments.getOutputFormat().equals(Format.BITS));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(""));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionBits_right() {
        String[] args = {"-f", "bits","-t", "bits", "--from-options=right"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.BITS));
            assert(arguments.getInputOption().equals(Option.RIGHT_PAD));
            assert(arguments.getOutputFormat().equals(Format.BITS));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(""));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionBits_big() {
        String[] args = {"-f", "bits","-t", "bits", "--from-options=big"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionBits_curly() {
        String[] args = {"-f", "bits","-t", "bits", "--to-options={}"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionBits_a() {
        String[] args = {"-f", "bits","-t", "bits", "--to-options=a"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }


    /* Hex format */
    @Test
    void formatHex_short() {
        String[] args = {"-f", "hex","-t", "hex"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.HEX));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.HEX));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void formatHex_long() {
        String[] args = {"--from=hex","--to=hex"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.HEX));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.HEX));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    /* Hex options */
    @Test
    void optionHex_delimiter() {
        String[] args = {"-f", "hex","-t", "hex", "--delimiter= "};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.HEX));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.HEX));
            assert(arguments.getOutputOption().equals(Option.NONE));
            assert(arguments.getOutputBrackets().equals(Option.NONE));
            assert(arguments.getDelimiter().equals(" "));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionHex_big() {
        String[] args = {"-f", "hex","-t", "hex", "--from-options=big"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionHex_left() {
        String[] args = {"-f", "hex","-t", "hex", "--to-options=left"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionHex_0x() {
        String[] args = {"-f", "hex","-t", "hex", "--to-options=0x"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    /* Array format */
    @Test
    void formatArray_short() {
        String[] args = {"-f", "array","-t", "array"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.HEX));
            assert(arguments.getOutputBrackets().equals(Option.CURLY_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void formatArray_long() {
        String[] args = {"--from=array","--to=array"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.HEX));
            assert(arguments.getOutputBrackets().equals(Option.CURLY_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    /* Array options */
    @Test
    void optionArray_char() {
        String[] args = {"--from=array","--to=array", "--to-options=a"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.CHAR));
            assert(arguments.getOutputBrackets().equals(Option.CURLY_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionArray_bitSquare() {
        String[] args = {"--from=array","--to=array", "--to-options=0b", "--to-options=]"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.BIT));
            assert(arguments.getOutputBrackets().equals(Option.SQUARE_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionArray_decRegular() {
        String[] args = {"--from=array","--to=array", "--to-options=0b", "--to-options=()", "--to-options=0"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.DEC));
            assert(arguments.getOutputBrackets().equals(Option.REGULAR_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionArray_hexCurly() {
        String[] args = { "--to-options=()", "--from=array","--to=array", "--to-options=0b", "--to-options={", "--to-options=0x"};
        try {
            ProgramArguments arguments = new ProgramArguments(args);
            assert(arguments.getInputFormat().equals(Format.ARRAY));
            assert(arguments.getInputOption().equals(Option.NONE));
            assert(arguments.getOutputFormat().equals(Format.ARRAY));
            assert(arguments.getOutputOption().equals(Option.HEX));
            assert(arguments.getOutputBrackets().equals(Option.CURLY_BRACKETS));
            assert(arguments.getDelimiter().equals("\n"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void optionArray_wrongNumOption() {
        String[] args = { "--to-options=()", "--from=array","--to=array", "--to-options=0b", "--to-options={", "--to-options=x"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void optionArray_wrongBrackets() {
        String[] args = { "--to-options=()", "--from=array","--to=array", "--to-options=0b", "--to-options=."};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    /* General errors */
    @Test
    void unknownInputFormat() {
        String[] args = { "--to-options=()", "--from=arra","--to=array", "--to-options=0b"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void unknownOutputFormat() {
        String[] args = { "--to-options=()", "--from=array","--to=rray", "--to-options=0b"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void invalidOptionFormat() {
        String[] args = { "- -to-options=()", "--from=array","--to=array", "--to-options=0b"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void unknownOption() {
        String[] args = {"-m", "hex","-t", "hex"};
        try {
            new ProgramArguments(args);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }
}