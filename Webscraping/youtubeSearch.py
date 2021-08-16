import webbrowser, sys

sys.argv

#Check if cli arguments were passed
if len(sys.argv) > 1:
    search = ' '.join(sys.argv[1:])

#will open up youtube and search what you entered
try:
    webbrowser.open('https://www.youtube.com/results?search_query=' + search)
except NameError:
    print('You did not enter a search')

# must be in folder where program is located in cli
# run python3 youtubeSearch.py python tutorials to search youtube for python tutorials

