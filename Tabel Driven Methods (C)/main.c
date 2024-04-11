#include <stdio.h>
#include <string.h>

#define TRUE 1
#define FALSE 0

// Struct to hold interimResult values between states.
typedef struct {
    float p;
    int s;
    float v;
} interimResult;

// Verify input is a digit
int digitInputVerifier(char c) {
    int asciiChar = (int)c;
    if (47 < asciiChar) {
        if (asciiChar < 58) {
            return TRUE;
        }
    }
    return FALSE;
}
// Verify input is minus
int minusInputVerifier(char c) {
    int asciiChar = (int)c;
    if (asciiChar == 45) {
        return TRUE;
    }
    return FALSE;
}
// Verify input is plus
int plusInputVerifier(char c) {
    int asciiChar = (int)c;
    if (asciiChar == 43) {
        return TRUE;
    }
    return FALSE;
}
// Verify input is period
int periodInputVerifier(char c) {
    int asciiChar = (int)c;
    if (asciiChar == 46) {
        return TRUE;
    }
    return FALSE;
}
// If period char is found
interimResult startFraction(interimResult result, char c) {
    result.p = 0.1;
    return result;
}

// If plus is found in start state
interimResult noAction(interimResult result, char c) {
    return result;
}
// If digit is found when currentState is decimal
interimResult continuingFractionAction(interimResult result, char c) {
    result.v = result.v + (result.p * (float)(c - '0'));
    result.p /= 10;
    return result;
}
// If digit is found when currentState is integer
interimResult continuingIntegerAction(interimResult result, char c) {
    result.v = 10 * result.v + (float)(c - '0');
    return result;
}
// If minus is found in start state
interimResult negateAction(interimResult result, char c) {
    result.s = -1;
    return result;
}
// If digit is found in start state
interimResult valueIsDigitAction(interimResult result, char c) {
    result.v = (float)(c - '0');
    return result;
}
// Define states of machine
enum State {Start, Integer, Decimal, Invalid};
// Define global state variable
enum State currentState;

// Define all the edges
struct Edges {
    enum State initialState;
    int (*verifier)(char);
    interimResult (*action)(interimResult, char);
    enum State nextState;
} edges[] = {
        {Start, &digitInputVerifier,&valueIsDigitAction, Integer},
        {Start, &minusInputVerifier, &negateAction, Integer},
        {Start, &plusInputVerifier,&noAction, Integer},
        {Start, &periodInputVerifier,&startFraction, Decimal},
        {Integer, &digitInputVerifier, &continuingIntegerAction, Integer},
        {Integer, &periodInputVerifier, &startFraction, Decimal},
        {Decimal, &digitInputVerifier, &continuingFractionAction, Decimal}
};

#define NUMCOMMANDS 7
struct Edges searchForEdge(enum State activeState, char activeChar) {
    // Loop over all edges looking for edge that matches initial state and edge's verifer is true
    for (int i = 0; i < NUMCOMMANDS; i++) {
        if (edges[i].initialState == activeState && edges[i].verifier(activeChar)) {
            return edges[i];
        }
    }
    // If edge is not found input must be invalid so return edge with invalid state.
    struct Edges nullEdge = {Invalid, 0, 0, Invalid};
    return nullEdge;
}

float parse(char *command)
{
    // Define initial state to Start
    currentState = Start;
    // Intialize interimResult
    interimResult result = {0, 1, 0};
    // Find length of command string
    int commandLength = strlen(command);

    for (int i = 0; i < commandLength; i++) {
        // Find character of command string at index i.
        char currentChar = command[i];

        // Look for matchign edge.
        struct Edges currentEdge = searchForEdge(currentState, currentChar);

        // If input is invalid return 0.
        if (currentEdge.initialState == Invalid) {
            return 0;
        }

        // update interimResult
        result = currentEdge.action(result, currentChar);
        // Set current state to next state
        currentState = currentEdge.nextState;

    }
    // Multiply sign by value
    float answer = (result.v * result.s);
    return answer;
}


int main(void) {
    printf("%f\n", parse("32.34"));
    printf("%f\n", parse("0.0.2"));
    printf("%f\n", parse("12f45"));
    printf("%f\n", parse("-775.342"));
    printf("%f\n", parse("+00012."));
    printf("%f\n", parse("+-/?&*%$"));
}