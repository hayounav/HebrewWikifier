#!/usr/bin/python
# -*- coding: utf-8 -*-

from pattern.web import plaintext
from pyquery import PyQuery as PQ
import codecs, re
from HTMLParser import HTMLParser

baseURL = "http://www.ynet.co.il"
categoryURLs = ["/home/0,7340,L-2,00.html", "/home/0,7340,L-544,00.html"]

visitedURLs = []
with codecs.open("hebrew_dataset/ynet_sentences.txt", encoding="utf8", mode="w") as outputFile:
	for catrgoryURL in categoryURLs:
		newsPage = PQ(baseURL+catrgoryURL)
		newsAnchors = newsPage("a[hm='1']")
		for anchor in newsAnchors:
			articleURL = baseURL+PQ(anchor).attr("href")
			if articleURL in visitedURLs:
				continue

			visitedURLs.append(articleURL)

			articlePage = PQ(articleURL)
			articleContent = articlePage.find("#article_content")
			PQ(articleContent).find("script, textarea.sf_embed_code, table").remove()
			articleContent = PQ(articleContent).find("p")
			parser = HTMLParser()
			cleanText = parser.unescape(plaintext(str(articleContent)))
			cleanText = re.sub(r'(\r?\n)+', '\n', cleanText)


			outputFile.write(cleanText)
			outputFile.write("\n")

