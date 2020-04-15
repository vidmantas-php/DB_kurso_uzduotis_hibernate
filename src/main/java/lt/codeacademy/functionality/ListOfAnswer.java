package lt.codeacademy.functionality;

import lt.codeacademy.input.Input;
import lt.codeacademy.output.Output;

import java.util.ArrayList;
import java.util.List;

public class ListOfAnswer {
    Output output = new Output();
    Input input = new Input();

    public List<String> getAnswersTextList() {
        List<String> listOfAnswerTexts = new ArrayList<String>();
        // answer a) text
        output.printInputAnswerA();
        String answerTextA = input.inputStringLine();
        listOfAnswerTexts.add(answerTextA);
        // answer b) text
        output.printInputAnswerB();
        String answerTextB = input.inputStringLine();
        listOfAnswerTexts.add(answerTextB);
        // answer c) text
        output.printInputAnswerC();
        String answerTextC = input.inputStringLine();
        listOfAnswerTexts.add(answerTextC);

        return listOfAnswerTexts;
    }

    public List<String> getAnswerLettersList() {
        List<String> listOfAnswerLetter = new ArrayList<String>();

        String a = "a)";
        listOfAnswerLetter.add(a);
        String b = "b)";
        listOfAnswerLetter.add(b);
        String c = "c)";
        listOfAnswerLetter.add(c);

        return listOfAnswerLetter;
    }
}
