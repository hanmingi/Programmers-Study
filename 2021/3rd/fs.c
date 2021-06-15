#include <stdio.h>
#include <stdlib.h>
/* remove the following comment if you want to use buffer cache probject (project #3) */
/* #include "buf.h" */
#include "fat.h"
#include "fs.h"


FileDescTable* pFileDescTable = NULL;


void FileSysInit(void) {

}


int OpenFile(const char* szFileName, OpenFlag flag, AccessMode mode) {

}


int WriteFile(int fileDesc, char* pBuffer, int length) {

}

int ReadFile(int fileDesc, char* pBuffer, int length) {

}


int CloseFile(int fileDesc) {

}

int RemoveFile(const char* szFileName) {

}


int MakeDirectory(const char* szDirName, AccessMode mode) {

}


int RemoveDirectory(const char* szDirName) {

}


void Format(void) {

}

void	Mount(void) {

}


void	Unmount(void) {

}



Directory* OpenDirectory(char* szDirName) {

}


FileInfo* ReadDirectory(Directory* pDir) {

}


int CloseDirectory(Directory* pDir) {

}
