package org.example;

// random script for each *Check() output
public class Script {
    static String[] mss_H = {"I like to drink soda.",
            "It's a nice day isn't it?",
            "Today is very cloudy, I wonder if I should bring umbrella?",
            "Can we hurry up?, I need to go home.",
            "Please check my ID carefully, the previous inspector almost got me killed!",
            "Hurry it up, this is taking too long.",
            "What?",
            "I'm tired please hurry",
            "What is taking so long?",
            "zZZ...",
            "What's up?",
            "I miss my wife.",
            "I miss my husband"};

    static String[] mss_A = {"I like to drink soda.",
            "Good day to be human, No?",
            "Today is very cloudy, I wonder if I should bring a beach ball?",
            "Can we hurry up?, I need to go home.",
            "I don't know anything about alien I swear!",
            "Hurry it up, this is taking too long.",
            "What?",
            "I'm not an imposter.",
            "What is taking so long?",
            "Um.. I like... to potato..?",
            "What's up?",
            "I miss my wife.",
            "I miss my husband"};

    public static String[] getScript_H() {
        return mss_H;
    }
    public static String[] getScript_A() {
        return mss_A;
    }
}
