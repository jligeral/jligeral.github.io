---
layout: essay
type: essay
title: "Respecting Other People's Time Pays Off"
# All dates must be YYYY-MM-DD format!
date: 2023-09-04
published: true
labels:
  - Questions
  - Answers
  - StackOverflow
---


## Prerequisite knowledge.

Before this semester started, I attended a New Student Orientation. We began the orientation in a large chemistry classroom, where someone from the faculty described all the different services available to us via the Campus Center. As she did this, she also answered questions in real time pertaining to the subject matter she address via mobile application. One student asked "Where can we park, and how do we pay for it?" The faculty member paused for a brief moment before asking a follow-up question "Did we all be sure to look through the New Student Orientation modules on Laulima before attending?" She then reminded everyone to look through them if they haven't already and that the answers to those questions would be found in them, specifically in the module about Commuter Services. I personally thought it was a harmless and simple question, but I've experienced this multiple times before. Many times, even.

Even within my circle of friends, I can be called out for asking a simple question. When does this game release? How much will it cost at launch? Should I play its predecessor before playing it? I sometimes see these questions asked on a Discord server, only to be met with aggressive responses telling the asker to use Google instead, even if everyone else could just answer the question themselves. I guess from my perspective, if I can Google the answer in a matter of seconds, why can't you? I don't mean to be rude, but I can understand that questions can lead others to believe the asker to be lazy. And I do want to clarify: I don't really believe in stupid questions if I think the asker is being genuine. But I do believe that there are appropriate and inappropriate times to ask "bad" or "stupid" questions, no matter how genuine the asker is.

## So who and when should I ask bad and dumb questions?

Definitely ask friends you know are willing to answer any question you ask. And, honestly, that's probably it. But if they don't have an answer for your question, then be prepared to either do some research of your own or look for the right experts who can answer your question. A couple weeks ago, I decided to go and fix a leak in my shower and bathtub. My initial action towards repairing the leak involved searching "leaking shower faucet" on Youtube. Many results came up, and I took some time to watch each and see if any of the leaks matched the one mine was exhibiting. I finally learned that the leak was the result of a faulty or old shower cartridge that was located behind the handle that controlled bothe the flow of water through the faucet, and the temperature of the water. What I didn't know was how to access the cartridge, what model type the cartridge was, and what I would need to even repair it. Luckily I happened to be friends with a former plumber. I called him, described what I was trying to do, and what my problems were, and he was quickly able to send me a tutorial video on the exact type of shower I was using. After that, fixing the shower extremely doable.

This story was meant to describe how one should approach asking for help. I did a preliminary amount of research and work before hitting a wall. Then I approached an expert, and provided them with all the knowledge I collected earlier, so that he could provide me with the rest of the information I required to solve my problem. The same goes for school - I took Japanese my last three semesters and always relied on a tutor to help me practice for oral examinations. But time with the tutor was limited since she was also at the service of several other Japanese students, and had a life of her own to take of. I couldn't very well just approach her, without having studied a bit and practiced beforehand - That could easily result in a waste of time. With my computer science classes, I'd sometimes get stuck implementing a data structure or fixing a bug when working on a class project. One resource I learned about, through social media and memes, was Stack Overflow. I personally came upon it a few times while asking certain Java-related questions on Google.

## How to waste everyone's time.

I figured I'd use two examples to illustrate what wasting time, in the act of posting a question, looks like.

[Here is an extreme example](https://stackoverflow.com/questions/77041101/write-a-program-of-java-having-class-vehicle-and-3-more-class-extends-vehicle)

```
Q: the vehicle class has 4 parameters- no. Of Wheels,speed,engine type,engine power. Create a constructor which can initialise these values. The sub class of the vehicle class would have few additional parameters if their of varying type . For ex: A cycle may have no. Of paddles .

Create few methods in order to exhibit method overriding.

used super and this keyword
```

People on Stack Overflow want to help others succeed. No one wants to do someone else's job or homework though. This type of question can likely be answered by a teacher during their office hours or a peer within the class. Even Google can probably provide a list of resources or tutorials that can answer this question. Creating a class, subclasses, constructors, and initializing them are all very basic actions one can learn within an hour.

[And here is a less extreme example](https://stackoverflow.com/questions/77038922/while-loop-in-main-method-for-java)

```
Q: I am trying to write my first Java program. The first step is to write a "greet the user" section. However, when the user enters a "blank" or "empty" value I want to handle that scenario using a While Loop.

When I do the build I get several errors. "Cannot resolve method "While" in "Main" is the first one I want to understand. I feel the others will be straightforward. This one I just cannot figure out.
```
In this case, the asker did *try* to at least work on their problem, but gave up too soon before actually checking their work. Simple mistakes and oversights do happen sometimes, but this is definitely a case simply searching up the error message on Google could have resulted in a quicker solution. In this case, the keyword "while" was capitalized when it should not have been - This is definitely a simple syntactical fix.

## And how not to.

[Why is processing a sorted array faster than processing an unsorted array?](https://stackoverflow.com/questions/11227809/why-is-processing-a-sorted-array-faster-than-processing-an-unsorted-array)

```
#include <algorithm>
#include <ctime>
#include <iostream>

int main()
{
    // Generate data
    const unsigned arraySize = 32768;
    int data[arraySize];

    for (unsigned c = 0; c < arraySize; ++c)
        data[c] = std::rand() % 256;

    // !!! With this, the next loop runs faster.
    std::sort(data, data + arraySize);

    // Test
    clock_t start = clock();
    long long sum = 0;
    for (unsigned i = 0; i < 100000; ++i)
    {
        for (unsigned c = 0; c < arraySize; ++c)
        {   // Primary loop.
            if (data[c] >= 128)
                sum += data[c];
        }
    }

    double elapsedTime = static_cast<double>(clock()-start) / CLOCKS_PER_SEC;

    std::cout << elapsedTime << '\n';
    std::cout << "sum = " << sum << '\n';
}

Q: My first thought was that sorting brings the data into the cache, but that's silly because the array was just generated.

What is going on?
Why is processing a sorted array faster than processing an unsorted array?
The code is summing up some independent terms, so the order should not matter.

```
I found all the questions in this essay by searching everything under the tag "java." This one in particular, I refined the search to look up questions with a high score, and it's not too difficult to see why this question is scored as high as it is. The asker presents code from two different languages (C++ and Java), with associated sorted and unsorted running times for each example. The asker then presents a hypothesis, followed by their question, and some details that they do know regarding the question being asked.

The fact that they displayed this is extremely helpful to those replying and answering the question posed. It provides an idea of what the asker *does* know so they can move on from explaining any elementary details, and the question and framing of it is specific enough that there are no broad and general responses that may fail to answer the question. One other detail that's important to notice is how many people responded, and how many people looked at the question. Many different resppnses and views is possibly evident of many people collaborating and learning together. Good questions help not only the asker, but potentially those answering too. Looking at the replies to each answer, you can see several follow-up questions and micro discussions - This is the type of result one should strive for if they intend to learn.

## Conclusion

I want to reiterate that I am not against asking "dumb" questions. If the genuine intent is to learn, then the question can't truly be bad. I want to say that the greatest takeaway is that doing adequate research before presenting our querries is far more efficient and considerate of other people's time than asking any question at any time. If I can tell that someone earnestly tried to learn something, but struggled to understand it, then I am more than eager to try to help them. I am far less eager to answer a question from someone who didn't even try because at some level, I don't think that exchange is worth exploring.
