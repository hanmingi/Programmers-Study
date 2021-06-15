#ifndef __DISK_H__
#define __DISK_H__


#define BLOCK_SIZE (128)

extern void DevCreateDisk(void);

extern void DevOpenDisk(void);
    
extern void DevReadBlock(int blkno, char* pBuf);

extern void DevWriteBlock(int blkno, char* pBuf);

extern int DevGetDiskReadCount(void);

extern int DevGetDiskWriteCount(void);

extern void DevResetDiskAccessCount(void);

#endif /* __DISK_H__ */

