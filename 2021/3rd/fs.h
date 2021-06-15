#ifndef __FILESYSTEM_H__
#define __FILESYSTEM_H__

#include "Disk.h"

typedef int BOOL;

// ------- Caution -----------------------------------------
#define FS_DISK_CAPACITY	(BLOCK_SIZE*BLOCK_SIZE/sizeof(int)*BLOCK_SIZE)

#define FILEINFO_START_BLOCK	(0)
#define FAT_BLOCKS		(129)
#define FAT_START_BLOCK		(1)
#define DATA_START_BLOCK	(FAT_START_BLOCK + FAT_BLOCKS)


#define NUM_OF_DIRENT_PER_BLK	(BLOCK_SIZE / sizeof(DirEntry))


#define NAME_LEN			(16)
#define DESC_ENTRY_NUM		(128)
#define MAX_FILE_NUM		(64)
// ----------------------------------------------------------


typedef enum __OpenFlag {
    OPEN_FLAG_READONLY,
    OPEN_FLAG_WRITEONLY,
    OPEN_FLAG_READWRITE
} OpenFlag;

typedef enum __AccessMode {
    ACCESS_MODE_READONLY,
    ACCESS_MODE_WRITEONLY,
    ACCESS_MODE_READWRITE
} AccessMode;

typedef enum __fileType {
    FILE_TYPE_FILE,
    FILE_TYPE_DIR,
    FILE_TYPE_DEV
} FileType;


typedef struct _FileSysInfo {
    int blocks;              
    int rootFatEntryNum;     
    int diskCapacity;        
    int numAllocBlocks;      
    int numFreeBlocks;       
    int numAllocFiles;       
    int fatTableStart;       
    int dataStart;           
} FileSysInfo;



typedef struct  __DirEntry {
     char name[NAME_LEN];        
     AccessMode mode;       
     int startBlockNum;    
     FileType filetype;    
     int numBlocks;        
} DirEntry;


typedef struct _File {
    BOOL     bUsed;
    OpenFlag flag;               
    int   dirBlkNum;            
    int   entryIndex;          
    int   fileOffset;         
} File;

typedef struct __FileTable {
    int  numUsedFile;
    File pFile[MAX_FILE_NUM];
} FileTable;


typedef struct _DescEntry {
    int bUsed;            
    File* pFile;         
} DescEntry;


typedef struct  __FileDescTable {
    int        numUsedDescEntry;      
    DescEntry  pEntry[DESC_ENTRY_NUM]; 
} FileDescTable;

typedef struct __Directory {
    int      dirBlkNum;      
    int      entryIndex;     
} Directory;

typedef struct _FileInfo { 
    char*     name[16];   
    AccessMode mode;      
    int startFatEntry;    
    FileType filetype;    
    int numBlocks;        
} FileInfo;


extern int		OpenFile(const char* szFileName, OpenFlag flag, AccessMode mode);
extern int		WriteFile(int fileDesc, char* pBuffer, int length);
extern int		ReadFile(int fileDesc, char* pBuffer, int length);
extern int		CloseFile(int fileDesc);
extern int		RemoveFile(const char* szFileName);
extern int		MakeDirectory(const char* szDirName, AccessMode mode);
extern int		RemoveDirectory(const char* szDirName);
extern void	Format(void);
extern void	Mount(void);
extern void	Unmount(void);
extern void 	FileSysInit(void);

extern Directory* OpenDirectory(char* name);
extern FileInfo*   ReadDirectory(Directory* pDir);
extern int          CloseDirectory(Directory* pDir);


extern FileDescTable* pFileDescTable;
extern FileSysInfo* pFileSysInfo;


#endif /* FILESYSTEM_H_ */

