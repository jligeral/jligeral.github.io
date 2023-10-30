---
layout: essay
type: essay
title: "Manoa Lost & Found"
# All dates must be YYYY-MM-DD format!
date: 2023-10-30
published: true
labels:
  - Software Engineering
  - Meteor
---
By <strong>Riki Macmillan</strong> & <b>James Ligeralde</b>

## Overview

People lose athings all the time. UH Manoa is a large campus, and maybe it's easier to ask other students to help them search for their lost items using some basic information, such as what it looks like and where it might have last been seen. This application should provide a means to help achieve that!

## Mockup page ideas

Pages included would be the landing page, a user page for regular users and admins, a page presenting a list of all lost items, and maybe a page for each lost item with descriptions of the item and means to communicate with users looking for the item.

## Use cases

<ul>
<li>We can define two roles: 1) Regular Users and 2) Admin Users</li>
<li>Landing page should have signup and login functionality.</li>
<li>Lost Item List page is accessible by everyone, logged in or not.</li>
<li>When logged in, users can manage a list of items they want to be found and can also interact with the Lost Item List page beyond just looking. Managing can included listing delisting lost items.</li>
<li>Each listed lost item has a description page to upload images, and details about how the item was lost, and maybe compensation for return of lost items</li>
</ul>

## Beyond the basics

<ul>
<li>A Report function should be added to allow admin users to manage special cases such as fraud.</li>
<li>Lost Items must be reviewed by admmin users prior to being added to the Lost Item List page.</li>
<li>Some method of applying a 'shelf life' to each listed item so that they are automatically delisted if not found. For example, if item not found after a year, the item is removed from the Lost Item List page.</li>
<li>Notifications for users when another user has found their item. Also for messages.</li>
</ul>
