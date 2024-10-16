# -*- coding: utf-8 -*-
"""
Created on Sat Jun 29 22:11:00 2024

@author: kcprasuhn
"""

import numpy as np
import matplotlib.pyplot as plt

# All black image
np.random.seed(0)  # Set seed for reproducibility
A = np.ones((8, 12))  # Create an 8x12 array filled with ones
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# All white image
np.random.seed(0)  # Set seed for reproducibility
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Gray image
np.random.seed(0)  # Set seed for reproducibility
A = np.full((8, 12), 0.5)  # Create an 8x12 array filled with 0.5 (gray)
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Half black, half white image
np.random.seed(0)  # Set seed for reproducibility
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
A[:, 6:] = 1  # Set the right half to ones (white)
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Half black, half gray horizontally
np.random.seed(0)  # Set seed for reproducibility
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
A[4:, :] = 0.5  # Set the bottom half to 0.5 (gray)
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Quadrants: black, gray, gray, white
np.random.seed(0)  # Set seed for reproducibility
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
A[4:, :6] = 0.5  # Bottom left quadrant to 0.5 (gray)
A[:4, 6:] = 0.5  # Top right quadrant to 0.5 (gray)
A[4:, 6:] = 1  # Bottom right quadrant to 1 (white)
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Diagonal line
np.random.seed(0)  # Set seed for reproducibility
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for i in range(min(A.shape)):  # Set diagonal to ones
    A[i, i] = 1
plt.figure()  # Create a new figure
print(A)  # Print the array
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array as a grayscale image

# Gradual change vertically
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for i in range(A.shape[0]):  # Gradually change rows from black to white
    A[i, :] = np.linspace(0, 1, A.shape[1])
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Gradual change horizontally
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for j in range(A.shape[1]):  # Gradually change columns from black to white
    A[:, j] = np.linspace(0, 1, A.shape[0])
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Black and white stripes horizontally
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for i in range(A.shape[0]):  # Alternating rows of black and white
    if i % 2 == 0:
        A[i, :] = 0  # Black row
    else:
        A[i, :] = 1  # White row
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Black and white stripes vertically
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for i in range(A.shape[1]):  # Alternating columns of black and white
    if i % 2 == 0:
        A[:, i] = 0  # Black column
    else:
        A[:, i] = 1  # White column
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Chessboard pattern
A = np.zeros((8, 12))  # Create an 8x12 array filled with zeros
for i in range(A.shape[0]):
    for j in range(A.shape[1]):
        if (i + j) % 2 == 0:  # Check if the sum of row and column indices is even or odd
            A[i, j] = 1  # White square
        else:
            A[i, j] = 0  # Black square
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Lab Part 2. The black and grey ones are already done

# All red
Red = (1.0, 0.0, 0.0)  # Define red color
A = np.ones((8, 12, 3))  # Create an 8x12x3 array filled with ones
A[:, :] = Red  # Set entire array to red
plt.imshow(A)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# All green
Green = (0.0, 1.0, 0.0)  # Define green color
A = np.ones((8, 12, 3))  # Create an 8x12x3 array filled with ones
A[:, :] = Green  # Set entire array to green
plt.imshow(A)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# All blue
Blue = (0.0, 0.0, 1.0)  # Define blue color
A = np.ones((8, 12, 3))  # Create an 8x12x3 array filled with ones
A[:, :] = Blue  # Set entire array to blue
plt.imshow(A)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# All purple
Purple = (1.0, 0.0, 1.0)  # Define purple color
A = np.ones((8, 12, 3))  # Create an 8x12x3 array filled with ones
A[:, :] = Purple  # Set entire array to purple
plt.imshow(A)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# Gradual change from black to red horizontally
A = np.zeros((8, 12, 3))  # Create an 8x12x3 array filled with zeros
for j in range(A.shape[1]):  # Gradually change columns from black to red
    A[:, j, 0] = np.linspace(0, 1, A.shape[0])  # Set red channel
plt.imshow(A, cmap='gray', vmin=0, vmax=1)  # Display the array
plt.axis('off')  # Turn off axis
plt.show()

# gradually from black to blue horizontally
A = np.zeros((8, 12, 3))     #creating a 3d array full of zeros(RGB)
for j in range(A.shape[0]):  
    A[j, :, 2] = np.linspace(0, 1, A.shape[1])    #changing the rgb of the pixels to a more bluish style
plt.imshow(A, cmap='gray', vmin=0, vmax=1)
plt.axis('off')  
plt.show()

# multicolor gradient
rows = 8
cols = 12

gradient = np.zeros((rows, cols, 3))

top_left = np.array([0, 0, 0])       # black
bottom_left = np.array([1, 0, 0])    # red
top_right = np.array([0, 1, 0])      # green
bottom_right = np.array([1, 1, 0])   # yellow

for i in range(rows):
    for j in range(cols):
        gradient[i, j] = (1 - i / (rows - 1)) * ((1 - j / (cols - 1)) * top_left + (j / (cols - 1)) * top_right) + \
                         (i / (rows - 1)) * ((1 - j / (cols - 1)) * bottom_left + (j / (cols - 1)) * bottom_right)                #this formula allows you to create the effect

plt.imshow(gradient, interpolation='nearest')
plt.axis('off')
plt.show()

# black and red stripes vertically
rows = 8
cols = 12

grid = np.zeros((rows, cols, 3))

for j in range(cols):
    if (j) % 2 == 0:
        grid[:, j] = [0, 0, 0]   # black stripe
    else:
        grid[:, j] = [1, 0, 0]   # red stripe

plt.imshow(grid, interpolation='nearest')
plt.axis('off')
plt.show()

# Black and green horizontal stripes
rows = 8
cols = 12

grid = np.zeros((rows, cols, 3))

for i in range(rows):
    if i % 2 == 0:
        grid[i, :] = [0, 0, 0]   # black stripe
    else:
        grid[i, :] = [0, 1, 0]   # green stripe

plt.imshow(grid, interpolation='nearest')
plt.axis('off')
plt.show()

# Black, red, green and yellow squares
rows = 8
cols = 12

grid = np.zeros((rows, cols, 3))

colors = [
    [0, 0, 0],    # black
    [1, 0, 0],    # red
    [0, 1, 0],    # green
    [1, 1, 0]     # yellow
]

for i in range(rows):
    for j in range(cols):
        if (i) % 2 == 0:
            color_index = j % 2   # alternate between black and red
        else: 
            color_index = (j) % 2 + 2   # alternate between green and yellow
        
        grid[i, j] = colors[color_index]

plt.imshow(grid, interpolation='nearest')
plt.axis('off')
plt.show()

# part 3 Lab 1 - Manipulations on digit images
d = np.load('digits.npy')
digits = [d[i] for i in range(10)]

def mix_rows(im1, im2):
    img = np.zeros(im1.shape, dtype=int)
    img[::2] = im1[::2]   # take even rows from im1
    img[1::2] = im2[1::2]   # take odd rows from im2
    return img

plt.figure(figsize=(3, 4))
plt.imshow(mix_rows(d[0], d[1]), cmap='gray', vmin=0, vmax=255)

def mix_cols(im1, im2):
    img = np.zeros(im1.shape, dtype=int)
    img[:, ::2] = im1[:, ::2]   # take even columns from im1
    img[:, 1::2] = im2[:, 1::2]   # take odd columns from im2
    return img

plt.figure(figsize=(3, 4))
plt.imshow(mix_cols(d[2], d[3]), cmap='gray', vmin=0, vmax=255)

def grayscale_to_color(im):
    img = np.stack((im,) * 3, axis=-1)   # convert grayscale to color image by multyplying the rgb colors by a certain formula
    return img

plt.figure(figsize=(3, 4))
plt.imshow(grayscale_to_color(d[4]), cmap='gray', vmin=0, vmax=255);

def grayscale_to_red(im):
    img = np.zeros((*im.shape, 3), dtype=int)
    img[..., 0] = im   # set the red channel to grayscale values by changing the rgb colors to reds ones
    return img

plt.figure(figsize=(3, 4))
plt.imshow(grayscale_to_red(d[5]), cmap='gray', vmin=0, vmax=255);

def change_background(im, b=[255, 0, 0]):
    img = np.stack((im,) * 3, axis=-1)
    mask = im == 0
    img[mask] = b   # change background color based on mask
    return img

plt.figure(figsize=(3, 4))
plt.imshow(change_background(d[6]), cmap='gray', vmin=0, vmax=255);

def mirror(im):
    img = np.fliplr(im)   # mirror image horizontally, by switching the data of 2D arrays by rows and columns
    return img

plt.figure(figsize=(3, 4))
plt.imshow(mirror(d[7]), cmap='gray', vmin=0, vmax=255);

def negative(im):
    img = 255 - im   # invert colos, with 255 and subtracting the rgb color
    return img

plt.figure(figsize=(3, 4))
plt.imshow(negative(d[8]), cmap='gray', vmin=0, vmax=255);

def upside_down(im):
    img = np.flipud(im)   # flip image vertically, by changing the rows
    return img

plt.figure(figsize=(3, 4))
plt.imshow(upside_down(d[9]), cmap='gray', vmin=0, vmax=255);

def crop(im):
    rows = np.any(im != 0, axis=1)
    cols = np.any(im != 0, axis=0)
    img = im[np.ix_(rows, cols)]   # crop image based on non-zero values, if the rgb color is 0 just take it off
    return img

plt.figure(figsize=(3, 4))
plt.imshow(crop(d[0]), cmap='gray', vmin=0, vmax=255);

def brightest_pixel(im):
    return np.unravel_index(np.argmax(im, axis=None), im.shape)   # find brightest pixel, formula, usually with the number closer to 255

print(brightest_pixel(d[1]))

def mean_img(im_list):
    return np.mean(im_list, axis=0).astype(int)   # compute mean image from a list, usually similar to the average value

print(mean_img(d[2]))

# part 4 lab 1 - Image operations on UTEP.jpg
im = plt.imread('UTEP.jpg')
plt.imshow(im)

def color_to_grayscale(im):
    grayscale_img = np.dot(im[..., :3], [0.5, 0.5, 0.5])   # convert color image to grayscale, by coverting the rgb colors to the grey ones
    return grayscale_img

plt.figure(figsize=(3, 4))
plt.imshow(color_to_grayscale(im))

def mirror(im):
    return np.fliplr(im)   # mirror image horizontally, by switching the columns

plt.figure(figsize=(3, 4))
plt.imshow(mirror(im))

def upside_down(im):
    return np.flipud(im)   # flip image vertically, by switching the rows

plt.figure(figsize=(3, 4))
plt.imshow(upside_down(im))

def crop(im, r0=0, c0=0, r1=-1, c1=-1):
    if r1 == -1:
        r1 = im.shape[0]      
    if c1 == -1:
        c1 = im.shape[1]
    return im[r0:r1, c0:c1]   # crop image based on specified dimensions

plt.figure(figsize=(3, 4))
plt.imshow(crop(im))

def brightest_pixel(im):
    return np.unravel_index(np.argmax(im, axis=None), im.shape)   # find brightest pixel

print(brightest_pixel(im))